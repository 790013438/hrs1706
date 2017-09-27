
public class Gunman extends Person implements Candidate {
	private Candidate target;		// 被代理的对象
	
	public Gunman(String name) {
		super(name);
	}
	
	public void setTarget(Candidate target) {
		this.target = target;
	}

	@Override
	public void writeDownName() {
		target.writeDownName();
	}

	@Override
	public void answerTheQuestions() {
		System.out.println("奋笔疾书答案");
	}

	@Override
	public void submitPaper() {
		target.submitPaper();
	}

}
