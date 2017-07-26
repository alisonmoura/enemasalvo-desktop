import java.util.List;

import dao.QuestaoDAO;
import model.Questao;

public class JPATest {

	public static void main(String[] args) {
		QuestaoDAO dao = new QuestaoDAO();
		List<Questao> list = dao.buscarTodos();
		for (Questao questao : list) {
			System.out.println(questao.getTexto());
		}
	}

}
