package pack1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // ���N�G�X�g����
    String message = "�e�L�X�g�t�@�C�����A�b�v���[�h�ł��܂���ł����B";
    String s = null;//����۰�ސ���߽��\���������


    if (ServletFileUpload.isMultipartContent(req)) {
    //������߰��ް����ǂ����m�F���遜
    //�ʏ��form�n���̏ꍇ�ͤpost�ł�get�ł�URL�ݺ��ނ������̂�
    //�n���Ă���
    //̧���ް��Ȃǂ̏ꍇ�͑傫���̂Ť����߰��ް��Ƃ���ظ��Ă�
    //���ߍ���œn���Ă���
    //���̍ۤ�n����(�����html)�ɢenctype="multipart/form-data"�
    //�Ƃ����L�q���K�v�

      String dataDir = getServletContext().getRealPath("/") + "data";
      s = dataDir;
      //������گĺ�÷�Ă̎擾��
      //�@��÷�Ă̈Ӗ�������
      //�@�@��۸���ݸޓI�ɂͤ�u���ꂽ�󋵥�^����ꂽ����
      //
      //����گĺ�÷�ĂƂͤ�ȒP�Ɍ����ƻ���گĂ��ǂ̊��œ�����
      //����̂��Ƃ������
      //���̵�޼ު�Ă��擾���Ĥ���̒���getRealPath���\�b�h�����s
      //����Τ�����Ă���ꏊ���߽���擾�ł���

      DiskFileItemFactory factory = new DiskFileItemFactory();
      //̧�ق������̵ׂ�޼ު�Ă𐶐�
      ServletFileUpload uploader = new ServletFileUpload(factory);
      //̧�ق���۰�ނ���̵ׂ�޼ު�Ă𐶐�
      uploader.setFileSizeMax(1024 * 1024); // 1MB
      //�������l�̐ݒ�(�����ڂƂȂ�l������l)

      try {
        List<FileItem> fList = uploader.parseRequest(req);
      //--------------
      //List�͵�޼ު�Ă�z���ɊǗ��ł���׽
      //���^�̵�޼ު�Ă��Ǘ�����̂���< >�̒��ɋL�q����
                             //--------------------------
      //req�Ƃ��đ����Ă����ް���FileItem��޼ު�Ăɕ������
      //List�Ƃ��ĕԂ��
      //�����Ή��Ȃ̂�List�`�����������̼��тł͑Ώ�̧�ق�
      //1�Ȃ̂Ť�K��1�¡

        for (FileItem fItem : fList) {
        //�g��for����p���ĤfList�����޼ު�Ă�1�����o���Ĥ
        //�ϐ�fItem�Ɋi�[���Ă��礒��̏������s��

          if (!fItem.isFormField()) {
             //isFormField()�ŤfItem�ŊǗ����Ă����޼ު�Ă�
             //̧���ް�������̑���form�ް����𔻕ʂ��Ă���
             //form�ް��̏ꍇ��true��Ԃ������ȊO(̧���ް�)�Ȃ�
             //false��Ԃ�
             //����ɢ!���t���鎖��true��false�𔽓]�����Ă���

            File tmpFile = new File(fItem.getName());
            //̧�ٖ����擾���File��޼ު�Ă𐶐�
            String fileName = tmpFile.getName();
            //̧�ٖ����擾

            if (fileNameCheck(fileName)) {
              //���������ҿ��ނ𗘗p���Ḩ̂�ٖ��̌`������������
              File file = new File(dataDir + File.separator + fileName);
                                           //--------------
                                           //���тŗp�����Ă����؂蕶��
              fItem.write(file);
              message = "�e�L�X�g�t�@�C���u" + fileName + "�v���A�b�v���[�h���܂����B";
            } else {
              message = "�e�L�X�g�t�@�C���𐳂����w�肵�Ă��������B";
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      message = "form �^�O�� enctype ������ multipart/form-data ���w�肵�Ă��������B";
    }


    // ���X�|���X����
    resp.setContentType("text/html; charset=Windows-31J");
    PrintWriter out = resp.getWriter();
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
    out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=Windows-31J\" />");
    out.println("<title>�t�@�C���A�b�v���[�h</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>" + message + s + "</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  private boolean fileNameCheck(String fileName) {

    String regex = "^\\S+\\.txt$";
    //̧�ٖ��̌`���𢐳�K�\����Œ�`����
    Pattern pattern = Pattern.compile(regex);
    //�쐬��������K�\�����Ă���Pattern��޼ު�Ă𐶐�
    Matcher matcher = pattern.matcher(fileName);
    //�Ώۂ̕�����(̧�ٖ�)��n���Ĥ���K�\���ɓK�����邩����
    return matcher.matches();
    //�K�����Ă����true����Ă��Ȃ����false��Ԃ�

  }
}