package com.wn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wn.model.Job;

public class ExcelUtil {

	public static List<Map<String,String>> GetData(String path,int length) {
		Workbook wb =null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String,String>> list = null;
		String filePath = path;
		String columns[] = {"id","学号","姓名","性别","学历","学校","专业","毕业时间","就业企业","职位","薪资","就业城市","就业时间"};
		wb = readExcel(filePath);
		if(wb != null){
			//用来存放表中数据
			list = new ArrayList<Map<String,String>>();
			//获取第一个sheet
			sheet = wb.getSheetAt(0);
			//获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			System.out.println("rownum : " + rownum);
			//获取第一行
			row = sheet.getRow(0);
			//获取最大列数
			int colnum = row.getPhysicalNumberOfCells();
			System.out.println("colnum : " + colnum);
			for (int i = 1; i<rownum-length-1; i++) {
				Map<String,String> map = new LinkedHashMap<String,String>();
				if(row !=null){
					for (int j=0;j<colnum;j++){
						Cell cell = sheet.getRow(i).getCell(j);
						String value = getCellFormatValue(cell);
						System.out.println("value : " + value);
						map.put(columns[j], value);
					}
				}else{
					break;
				}
				list.add(map);
			}
		}
		return list;

	}
	
	//读取excel
	public static Workbook readExcel(String filePath){
		Workbook wb = null;
		
		if(filePath==null){
			return null;
		}
		System.out.println(filePath);
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if(".xls".equals(extString)){
				 wb = new HSSFWorkbook(is);
			}else if(".xlsx".equals(extString)){
				 wb = new XSSFWorkbook(is);
			}else{
				 wb = null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	//	判断数据的类型
	public static String getCellFormatValue(Cell cell){
		String str = "";
		DataFormatter formatter = new DataFormatter();
		if(cell != null) {
			switch (cell.getCellTypeEnum()) {
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
		            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            str = simpleDateFormat.format(date);
				}else {
					str = formatter.formatCellValue(cell);
				} 
				break;
			case STRING:
				str = cell.getStringCellValue();
				break;
			case FORMULA:
				break;
			case BLANK:
				break;
			case BOOLEAN:
				break;
			case ERROR:
				break;
			default:
				break;
			}
		}
		return str;
	}

	//提取每个值，为对象设置，返回对象
	public static List<Job> GetJob(List<Map<String, String>> list) {
		Job job = null;
		List<Job> jobList = new ArrayList<Job>();
		for (Map<String, String> map : list) {
			job = new Job();
			job.setId(Integer.parseInt(map.get("id")));
			job.setS_id(map.get("学号"));
			job.setS_name(map.get("姓名"));
			job.setS_sex(map.get("性别"));
			job.setS_education(map.get("学历"));
			job.setS_school(map.get("学校"));
			job.setS_major(map.get("专业"));
			job.setS_graduationtime(map.get("毕业时间"));
			job.setS_company(map.get("就业企业"));
			job.setS_post(map.get("职位"));
			job.setS_salary(map.get("薪资"));
			job.setS_city(map.get("就业城市"));
			job.setS_employmenttime(map.get("就业时间"));
			jobList.add(job);
		}
		return jobList;
	}
}
