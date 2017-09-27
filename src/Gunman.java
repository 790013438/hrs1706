
public class Gunman extends Person implements Candidate {
	private Candidate target;		// ������Ķ���
	
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
		System.out.println("�ܱʼ����");
	}

	@Override
	public void submitPaper() {
		target.submitPaper();
	}

}
