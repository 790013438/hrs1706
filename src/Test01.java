// 代理模式: 由代理对象去接管被代理对象(目标对象)的行为
// 代理对象在执行被代理对象行为时可以做更多的事情
// 实现代理模式的要点是代理对象和被代理对象实现相同的接口
// 代理对象关联被代理对象去执行被代理对象的行为
// 可以在执行前后添加附加代码来做更多的事情
public class Test01 {

	public static void main(String[] args) {
		LazyStudent student = new LazyStudent("王大锤");
		Gunman gunman = new Gunman("骆昊");
		Gunman gunman2 = new Gunman("宁高磊");
		gunman.setTarget(student);
		gunman2.setTarget(gunman);
		gunman2.writeDownName();
		gunman2.answerTheQuestions();
		gunman2.submitPaper();
	}
}
