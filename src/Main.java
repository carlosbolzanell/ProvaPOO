import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Pessoa usuarioLogado;

    public static void main(String[] args) {
        Lanche lanche = new Lanche(1, "Um lanche saboroso", 19.90);
        lanche.setNome("X-Salada Saboroso");
        Lanche lanche1 = new Lanche(2, "Um lanche delicioso", 39.90);
        lanche1.setNome("X-Bacon Delicioso");
        Bebida coca = new Bebida(3, "Coca cola geladinha", 5.50);
        coca.setNome("Coca Cola");
        Combo combo = new Combo(5, "O melhor combo da regiao", 36.70);
        combo.setNome("Romario's Gourmet");
        combo.adicionarItem(lanche1);
        combo.adicionarItem(coca);
        GerenciadorDeCardapio.adicionarProduto(coca);
        GerenciadorDeCardapio.adicionarProduto(combo);
        GerenciadorDeCardapio.adicionarProduto(lanche1);
        GerenciadorDeCardapio.adicionarProduto(lanche);
        Pessoa.adicionarUsuarios(new Cliente("Luana", "Brazil", "999"));
        Pessoa.adicionarUsuarios(new Garcom("Carlos", "Brazil", "999"));
        menu();
    }
    public static void menu(){
        System.out.println("""
                Bem vindo a lanchonete Romario's
                1 - Login
                """);
        int escolha = sc.nextInt();
        if(escolha == 1){
            login();
        }else{
            System.out.println("Opção inválida!");
        }
    }
    public static void login(){
        do {
            System.out.print("Nome: ");
            String nome = sc.next();
            Pessoa pessoa = Pessoa.login(nome);
            if(pessoa == null){
                System.out.println("Usuário não existe no nosso sistema");
                return;
            }
            if(pessoa instanceof Cliente){
                usuarioLogado = pessoa;
                menuCliente();
            }else{
                usuarioLogado = pessoa;
                menuGarcom();
            }
        }while (usuarioLogado == null);
    }
    public static void logout(){
        usuarioLogado = null;
    }
    public static void menuCliente(){
        do {
            System.out.println("""
                0 - logout
                1 - Fazer pedido
                2 - Cancelar pedido
                3 - Ver pedidos""");
            int escolha = sc.nextInt();
            switch (escolha){
                case 0 -> logout();
                case 1 -> cadastrarPedido();
                case 2 -> cancelarPedido();
                case 3 -> verPedidos();
            }
        }while (usuarioLogado != null);
    }
    public static void cancelarPedido(){
        System.out.print("Código do pedido: ");
        int codigo = sc.nextInt();
        if(usuarioLogado instanceof Cliente cliente1) {
            Pedido pedido = cliente1.procurarPedido(codigo);
            if (pedido == null) {
                System.out.println("Pedido não existe nesse cliente");
                return;
            }
            cliente1.cancelarPedido(pedido);
            System.out.println("Pedido cancelado com sucesso!");

        }
    }
    public static void verPedidos(){
        if(usuarioLogado instanceof Cliente cliente){
            System.out.println(cliente.viualizarPedido());
        }
    }
    public static void menuGarcom(){
        do {
            System.out.println("""
                0 - logout
                1 - Cadastrar Pedido
                2 - Exibir Menu
                3 - Adicionar Item no Pedido
                4 - Remover Item do Pedido
                5 - Confirmar Pedido
                6 - Calcular Pagamento
                7 - Remover Produto""");
            int escoha = sc.nextInt();
            switch (escoha){
                case 0 -> logout();
                case 1 -> cadastrarPedido();
                case 2 -> exibirMenu();
                case 3 -> adicionarItem();
                case 4 -> removerItem();
                case 5 -> confirmarPedido();
                case 6 -> calcularPagamento();
                case 7 -> removerProduto();
            }

        }while (usuarioLogado != null);
    }
    public static void cadastrarPedido(){
        System.out.print("Código do produto: ");
        int codigo = sc.nextInt();
        Produto produto = GerenciadorDeCardapio.procurarProduto(codigo);
        if(produto == null){
            System.out.println("Produto não existe no sistema");
            return;
        }
        if(usuarioLogado instanceof Cliente cliente1){
            Pedido pedido = new Pedido(cliente1, produto, "Em andamento");
            cliente1.fazerPedido(pedido);
            System.out.println("Pedido Cadastrado Com sucesso");

        }else if(usuarioLogado instanceof Garcom garcom){
            System.out.print("Qual o cliente: ");
            String nomeCliente = sc.next();
            Pessoa cliente = Pessoa.procuraCliente(nomeCliente);
            if(cliente == null){
                System.out.println("Cliente não existe no sistema!");
                return;
            }
            if(cliente instanceof Cliente cliente1) {
                garcom.cadastrarPedido(cliente1, produto);
                System.out.println("Pedido realizado com sucesso");
            }else{
                System.out.println("Usuário não é um cliente!");
            }
        }
    }
    public static void exibirMenu(){
        if(usuarioLogado instanceof Garcom garcom){
            System.out.println(garcom.exibirMenu());
        }
    }
    public static void adicionarItem(){
        System.out.print("Qual o cliente: ");
        String nomeCliente = sc.next();
        Pessoa cliente = Pessoa.procuraCliente(nomeCliente);
        if(cliente == null) {
            System.out.println("Cliente não existe no sistema!");
            return;
        }
        System.out.print("Código do pedido: ");
        int codigo = sc.nextInt();

        if(cliente instanceof Cliente cliente1){
            Pedido pedido = cliente1.procurarPedido(codigo);
            if(pedido == null){
                System.out.println("Pedido não existe nesse cliente");
                return;
            }

            if(usuarioLogado instanceof Garcom garcom){
                System.out.print("Código do produto: ");
                int codigo1 = sc.nextInt();
                Produto produto = GerenciadorDeCardapio.procurarProduto(codigo1);
                if(produto == null){
                    System.out.println("Produto não existe no sistema");
                    return;
                }
                garcom.adicionarItemAoPedido(pedido, produto);
                System.out.println("Produto adicionado com sucesso!");
            }
        }
    }
    public static void removerItem(){
        System.out.print("Qual o cliente: ");
        String nomeCliente = sc.next();
        Pessoa cliente = Pessoa.procuraCliente(nomeCliente);
        if(cliente == null) {
            System.out.println("Cliente não existe no sistema!");
            return;
        }
        System.out.print("Código do pedido: ");
        int codigo = sc.nextInt();

        if(cliente instanceof Cliente cliente1) {
            Pedido pedido = cliente1.procurarPedido(codigo);
            if (pedido == null) {
                System.out.println("Pedido não existe nesse cliente");
                return;
            }

            if (usuarioLogado instanceof Garcom garcom) {
                System.out.print("Código do produto: ");
                int codigo1 = sc.nextInt();
                Produto produto = GerenciadorDeCardapio.procurarProduto(codigo1);
                if(produto == null){
                    System.out.println("Produto não existe no sistema");
                    return;
                }
                garcom.removerItemDoPedido(pedido, codigo1);
                System.out.println("Pedido Removido com sucesso");
            }
        }
    }
    public static void confirmarPedido(){
        System.out.print("Qual o cliente: ");
        String nomeCliente = sc.next();
        Pessoa cliente = Pessoa.procuraCliente(nomeCliente);
        if(cliente == null) {
            System.out.println("Cliente não existe no sistema!");
            return;
        }
        System.out.print("Código do pedido: ");
        int codigo = sc.nextInt();

        if(cliente instanceof Cliente cliente1) {
            Pedido pedido = cliente1.procurarPedido(codigo);
            if (pedido == null) {
                System.out.println("Pedido não existe nesse cliente");
                return;
            }
            if(usuarioLogado instanceof Garcom garcom){
                garcom.confirmarPedido(pedido);
                System.out.println("Pedido confirmado!");
            }
        }
    }
    public static void calcularPagamento(){
        System.out.print("Qual o cliente: ");
        String nomeCliente = sc.next();
        Pessoa cliente = Pessoa.procuraCliente(nomeCliente);
        if(cliente == null) {
            System.out.println("Cliente não existe no sistema!");
            return;
        }
        System.out.print("Código do pedido: ");
        int codigo = sc.nextInt();

        if(cliente instanceof Cliente cliente1) {
            Pedido pedido = cliente1.procurarPedido(codigo);
            if (pedido == null) {
                System.out.println("Pedido não existe nesse cliente");
                return;
            }
            if(usuarioLogado instanceof Garcom garcom){

                System.out.println("R$ "+ garcom.calcularPagamento(pedido));
            }
        }
    }
    public static void removerProduto(){
        System.out.print("Código do produto: ");
        int codigo1 = sc.nextInt();
        Produto produto = GerenciadorDeCardapio.procurarProduto(codigo1);
        if(produto == null){
            System.out.println("Produto não existe no sistema");
            return;
        }
        GerenciadorDeCardapio.removerProduto(codigo1);
        System.out.println("Produto Removido!");
    }
}