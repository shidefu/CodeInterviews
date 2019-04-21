package Chapter1;

/**
 * 赋值运算符方法
 * 如下为类型MyString的声明，请为该类型添加赋值运算符方法。
 */

class MyString {

	String str = null;

	public MyString(String str) {
		this.str = str;
	};

	public MyString(MyString str) {
	};

	public String pData;
}

public class CodeInterviews01_OperatorAssignment {

	MyString OperatorAssignmen(String str) {
		if (str != null) {
			MyString strTemp = new MyString(str);
			String pTemp = strTemp.pData;
			strTemp.pData = str;
			str = pTemp;
			return strTemp;
		}
		return null;
	}

}
