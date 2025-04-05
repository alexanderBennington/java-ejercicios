import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.component.html',
  styleUrl: './producto-lista.component.css'
})
export class ProductoListaComponent {
  productos:Producto[];
  
  private productoServicio = inject(ProductoService);
  private enrutador = inject(Router);

  ngOnInit(){
    this.obtenerProductos();
  }

  private obtenerProductos():void{
    this.productoServicio.obtenerProductosLista().subscribe({
      next: (datos) => {
        this.productos = datos;
      },
      error: (error) => {
        console.error("Error al obtener datos", error);
      }
    });
  }

  editarProducto(id: number){
    this.enrutador.navigate(['editar-producto', id]);
  }

  eliminarProducto(id: number){
    this.productoServicio.eliminarProducto(id).subscribe({
      next: (datos) => this.obtenerProductos(),
      error: (errores) => console.log(errores)
    })
  }
}
