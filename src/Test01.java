// ����ģʽ: �ɴ������ȥ�ӹܱ��������(Ŀ�����)����Ϊ
// ���������ִ�б����������Ϊʱ���������������
// ʵ�ִ���ģʽ��Ҫ���Ǵ������ͱ��������ʵ����ͬ�Ľӿ�
// �������������������ȥִ�б�����������Ϊ
// ������ִ��ǰ����Ӹ��Ӵ����������������
public class Test01 {

	public static void main(String[] args) {
		LazyStudent student = new LazyStudent("����");
		Gunman gunman = new Gunman("���");
		Gunman gunman2 = new Gunman("������");
		gunman.setTarget(student);
		gunman2.setTarget(gunman);
		gunman2.writeDownName();
		gunman2.answerTheQuestions();
		gunman2.submitPaper();
	}
}
