package com.andersenmota.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.andersenmota.cursomc.domain.Categoria;
import com.andersenmota.cursomc.domain.Cidade;
import com.andersenmota.cursomc.domain.Cliente;
import com.andersenmota.cursomc.domain.Endereco;
import com.andersenmota.cursomc.domain.Estado;
import com.andersenmota.cursomc.domain.Pagamento;
import com.andersenmota.cursomc.domain.PagamentoComBoleto;
import com.andersenmota.cursomc.domain.PagamentoComCartao;
import com.andersenmota.cursomc.domain.Pedido;
import com.andersenmota.cursomc.domain.Produto;
import com.andersenmota.cursomc.domain.enums.EstadoPagamento;
import com.andersenmota.cursomc.domain.enums.TipoCliente;
import com.andersenmota.cursomc.repositories.CategoriaRepository;
import com.andersenmota.cursomc.repositories.CidadeRepository;
import com.andersenmota.cursomc.repositories.ClienteRepository;
import com.andersenmota.cursomc.repositories.EnderecoRepository;
import com.andersenmota.cursomc.repositories.EstadoRepository;
import com.andersenmota.cursomc.repositories.PagamentoRepository;
import com.andersenmota.cursomc.repositories.PedidoRepository;
import com.andersenmota.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    @Autowired
	private CategoriaRepository categoriarepository;
    @Autowired
    private ProdutoRepository produtorepository;
    @Autowired
    private CidadeRepository cidaderepository;
    @Autowired
    private EstadoRepository estadorepository;
    @Autowired
    private ClienteRepository clienterepository;
    @Autowired
    private EnderecoRepository enderecorepository;
    @Autowired
    private PedidoRepository pedidorepository;
    @Autowired
    private PagamentoRepository pagamentorepository;
    
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		produtorepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadorepository.saveAll(Arrays.asList(est1, est2));
		cidaderepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "84230939429", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("0984323","098342"));
		
		Endereco e1 = new Endereco(null, "Avenida Flores", "300", "Apto303", "Jardim", "3123", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 8000", "Centro", "872332", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienterepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidorepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentorepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}
