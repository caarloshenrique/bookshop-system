import java.util.Scanner;

public class Executavel {
    public static void main(String[] args) throws Exception {
        Livro l;
        LivroDAO dao = new LivroDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o ID do livro para atualizar");
        Integer id = sc.nextInt();
        l = dao.procurarLivro(id);
        if (l != null) {
            System.out.println("Só é permitida a atualização do título!");
            System.out.println("Entre com o novo titulo: ");
            l.setTitulo(sc.nextLine());
            dao.atualizarLivro(l);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
