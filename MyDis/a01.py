import unittest
import os
import HTMLTestRunner

# TestCase 测试用例类：所有的测试类必须继承他才具备测试执行的能力
# unittest.mian() 默认会执行所有以test命名开头的测试用例
# unittest 四要素：
'''
test case:测试用例
test fixture:测试装置   用例执行前的环境准备部件,用例执行,用例执行完后的环境清理部件
test suite:测试套件     测试集，测试用例组成测试集
test runner:测试执行

'''
class Caculator():
    def divide(self,x,y):
        return x/y

#代码级接口测试，单元测试（unit test）
class unit_case(unittest.TestCase):
    def setUp(self):
        print("begin")

    def tearDown(self):
        print("end")

    def test001(self):
        print("this is test001")

    def test002(self):
        print("this is test002")

class TestCaculator(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        print("开始")
    @classmethod
    def tearDownClass(cls):
        print("结束")

    # @unittest.skipUnless(1>2,reason="条件为假时跳过")
    def testdivide01(self):
        cal = Caculator()
        actural = cal.divide(10,5)
        self.assertEqual(actural,2)
        print("欢迎你")

    # @unittest.skipIf(2>1,reason="条件为真时跳过")
    def testdivide02(self):
        cal = Caculator()
        result = cal.divide(10,2)
        self.assertEqual(result,5,result!=2)
        print("你好呀")

    # @unittest.skip(reason="强制跳过")
    def testdivide03(self):
        cal = Caculator()
        result = cal.divide(100,2)
        self.assertEqual(result,50,"出错啦")
        print("哈哈")

if __name__ == '__main__':
    # unittest.main()

    #创建一个测试集
    suite = unittest.TestSuite()
    #1.在这个测试集中添加一个测试用例
    # suite.addTest(TestCaculator('testdivide02'))
    #2.添加多个测试用例到测试集
    # suite.addTests([TestCaculator('testdivide01'),TestCaculator('testdivide02')])
    #3.添加测试用例所属的整个类到测试集
    suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestCaculator))
    #4.指定测试用例的名称进行添加测试集，以字符串的形式进行传参，规则是：模块名.类名.方法名
    # suite.addTests(unittest.TestLoader().loadTestsFromName("a01.unit_case.test001"))
    #5.根据名称指定多个测试用例添加到测试集
    # suite.addTests(unittest.TestLoader().loadTestsFromNames(["a01.TestCaculator.testdivide01","a01.TestCaculator.testdivide02"]))
    #6.根据导入模块名来添加测试用例到测试集
    # suite.addTests(unittest.TestLoader().loadTestsFromModule(a01))
    #实例化一个执行对象
    # runner = unittest.TextTestRunner(verbosity=1)
    #运行测试集
    # runner.run(suite)

    #7.实例化一个result来保存测试结果
    # result = unittest.TestResult(suite)
    # suite.run(result)
    # print(result.__dict__)
    # print(result.testsRun)
    # print(result.failures)

    #8.使用python-unittest自带的方式TextTestRunner，将结果保存到报告文件中
    # with open("report.txt","w",encoding="utf8")as f:
    #     runner = unittest.TextTestRunner(stream=f,verbosity=2)
    #     runner.run(suite)

    #9.使用第三方库HTMLTestRunner，输出测试结果
    with open("report.html","w",encoding="utf8")as f:
        runner = HTMLTestRunner.HTMLTestRunner(stream=f,title="报告",verbosity=1,description="简单的测试用例描述")
        runner.run(suite)


























