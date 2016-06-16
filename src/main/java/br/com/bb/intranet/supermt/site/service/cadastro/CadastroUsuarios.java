package br.com.bb.intranet.supermt.site.service.cadastro;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.site.model.Usuario;
import br.com.bb.intranet.supermt.site.repository.Usuarios;
import br.com.bb.intranet.supermt.site.service.NegocioException;
import br.com.bb.intranet.supermt.site.util.Transactional;

public class CadastroUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public void salvar(Usuario usuario) throws NegocioException{
		if(usuario == null || "".equals(usuario.getChave())){
			throw new NegocioException("Usuario inválido!");
		}else if(this.usuarios.porChave(usuario.getChave()) != null){
			throw new NegocioException("Chave já cadastrada!");
		}
		
		this.usuarios.adicionar(usuario);
	}

	@Transactional
	public void atualizar(Usuario usuario) throws NegocioException{
		if(usuario == null || "".equals(usuario.getChave())){
			throw new NegocioException("Usuario inválido!");
		}else if(this.usuarios.porChave(usuario.getChave()) == null){
			throw new NegocioException("Usuario não cadastrado!");
		}
		
		this.usuarios.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario) throws NegocioException{
		usuario = this.usuarios.porId(usuario.getId());
		
		if(usuario == null){
			throw new NegocioException("Usuario não existe!");
		}
		
		this.usuarios.remover(usuario);
	}
}
