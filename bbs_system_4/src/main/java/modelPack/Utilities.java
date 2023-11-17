package modelPack;

/**
 * ���샆�[�e�B���e�B�[�Ǘ��p�N���X
 *
 * @author N.Fukuda
 */
public class Utilities {

	/**
	 * ���R�[�h�����󂯎���Ĥ20�����̃y�[�W�J�ڂ���ׂ̃p�[�c�𐶐�����
	 *
	 * @param servlet URL�������ɕK�v��path�̈ꕔ(thred,res�̉��ꂩ)
	 * @param id URL�Ƀp�����[�^�Ƃ��ĕs����thread_id
	 * @param recordCount (����thread_id��)�S�̃��R�[�h��
	 * @return ���������y�[�W�J�ڗp�p�[�c
	 */
	public static String editPages(String servlet, String threadId, int recordCount) {
		String pages = "<p class=\"editPages\">�y�[�W�w��\��&nbsp;"; //p�J�n�^�O�Ŏn�܂�

		if (threadId.equals("")) {
			pages += ("(�X���b�h���쏇)&nbsp;&nbsp;");
		}
		//���킴�Ə�����true�ɂ��Ĥٰ�ߓ���break�����鎖���Î����Ă���
		//�@(�߰���߰̍Ŋ���"/"��t���Ȃ��悤�ɂ���פٰ�߂̓r���Ŕ�����)
		for (int i = 1; true; i++) {

			//a�J�n�^�O & ��{URL
			pages += ("<a href=\"" + servlet + "?");

			//id�p�����[�^(���X�y�[�W�̂�)
			if (!threadId.equals("")) {
				pages += ("threadId=" + threadId + "&");
			}

			//page�p�����[�^
			pages += ("page=" + i);

			//a�J�n�^�O������ & �\���p�y�[�WNo & a���^�O
			pages += ("\">" + i + "</a>");

			//���[�v��������
			if (i * 20 >= recordCount) {
				break;
			}

			//�\���p�y�[�W�����L��
			pages += " / ";
		}

		return pages += "</p>"; //p���^�O�ŏI���

	}

}