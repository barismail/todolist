public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus: aplikasi todolist";
        showTodoList();
    }

    /**
     * menambahkan todo ke list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh
        var isFull = true;
        for (String s : model) {
            if (s == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh resize model 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Test contoh ke- " + i);
        }

        showTodoList();
    }

    /**
     * menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if (number - 1 >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = number - 1; i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        boolean result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        String name = input("Name");
        System.out.println("Hi " + name);
    }

    /**
     * menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Enter your choice: ");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");

        viewShowTodoList();
    }

    /**
     * menampilkan view add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        String todo = input("Todo: (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * menampilkan view remove todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        String number = input("Nomor yang di hapus: (x jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean isSuccess = removeTodoList(Integer.valueOf(number));
            if (!isSuccess) {
                System.out.println("Gagal menghapus todolist: " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
