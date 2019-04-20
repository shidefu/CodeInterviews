package Chapter1;

/** 
 * 实现单例模式
 * 设计一个类,只能生成该类的一个实例,
 */

//双检验锁单例模式
public class CodeInterviews02_Singleton {// 使用双重校验锁实现对象单例
// volatile关键字可以禁止JVM指令重排，保证多线程下能正常执行
	private volatile static CodeInterviews02_Singleton uniqueInstance;

	private CodeInterviews02_Singleton() {

	}

	public static CodeInterviews02_Singleton getUniqueInstance() {
		// 先判断对象是否已经实例过，没有实例化的对象才能进入加锁代码块；
		if (uniqueInstance == null) {
			// 对当前类对象加锁，进入同步代码块之前要获得当前类对象的锁；
			synchronized (CodeInterviews02_Singleton.class) {

				if (uniqueInstance == null) {

					uniqueInstance = new CodeInterviews02_Singleton();
				}
			}
		}

		return uniqueInstance;
	}
}
