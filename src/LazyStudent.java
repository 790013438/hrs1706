
public class LazyStudent extends Person implements Candidate {

	public LazyStudent(String name) {
		super(name);
	}

	@Override
	public void writeDownName() {
		System.out.println("����: " + name);
	}

	@Override
	public void answerTheQuestions() {
	}

	@Override
	public void submitPaper() {
		System.out.println(name + "�ύ�Ծ�");
	}

}
