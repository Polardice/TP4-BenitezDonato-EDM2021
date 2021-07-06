package ar.unju.edu.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("impprodmysql")
	ProductoService iProductoService;

	@GetMapping("/producto/mostrar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return ("producto");
	}

	@PostMapping("/producto/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
		return "redirect:/producto/mostrar";
	}

	@GetMapping("/ultimo")
	public String cargarUltimoProducto(Model model) {
		model.addAttribute("ultimoProducto", iProductoService.obtenerUltimoProducto());
		return("mostrar-ultimo");
	}
	
	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		// model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return ("redirect:/producto");
	}
	
	@GetMapping("/producto/vender")
	public String cargarProductoVender(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("venta");
	}
	
	@GetMapping("/producto/comprar/{id}")	
	public String editarClienteCompra(Model model, @PathVariable(name="id") int id) throws Exception {
		Producto productoSeleccionado = new Producto();		
		try {		
			productoSeleccionado = iProductoService.obtenerUnProducto(id);		
			model.addAttribute("productoSeleccionado",productoSeleccionado);
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
		}		
		return "venta-modal";
	}
}
