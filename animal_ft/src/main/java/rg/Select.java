package rg;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Select {
	public void execute(HttpServletRequest request) throws Exception {

		Dao dao = null;

		try {
			dao = new Dao();
			int uranai_id60 = dao.calculateValue(request.getParameter("year"), request.getParameter("month"),
					request.getParameter("day"));
			SixtyAnimalsEntity aixtyAnimal = dao.getSixtyAnimals(uranai_id60);
			String picString = dao.getPicture(aixtyAnimal.getId());
			//			System.out.println(aixtyAnimal.getName());
			//			System.out.println(aixtyAnimal.getId());
			System.out.println(picString);
			if (aixtyAnimal != null) {
				request.setAttribute("aixtyAnimal", aixtyAnimal);
				request.setAttribute("picString", picString);

			}

		} catch (SQLException e) {
			request.setAttribute("message", "JDBCÇÃÉGÉâÅ[Ç≈Ç∑");
		}

		if (dao != null) {
			dao.close();
		}

	}
}