import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AgregarEmpleado() {

    let navegacion = useNavigate();

    const [empleado, setEmpleado] = useState({
        nombre: "",
        departamento: "",
        sueldo: ""
    });
    

    const{nombre, departamento, sueldo} = empleado;

    const onInputChange = (e) => {
        setEmpleado({...empleado, [e.target.name]: e.target.value})
    }

    const onSubmit = async (e) => {
        e.preventDefault();
        const urlBase = "http://localhost:8080/rh-app/empleados";
        try {
            await axios.post(urlBase, empleado);
            navegacion("/");
        } catch (error) {
            console.error("Error al agregar empleado:", error);
            alert("No se pudo guardar el empleado. Revisa la consola.");
        }
    }
    

    return (
        <div className='container'>
            <h1 className='text-center mt-5 mb-5'>Agregar Empleado</h1>
            <form onSubmit={(e) => onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="nombre" className="form-label">Nombre</label>
                    <input type="text" className="form-control" id="nombre" name='nombre' required value={nombre} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="departamento" className="form-label">Departamento</label>
                    <input type="text" className="form-control" id="departamento" name='departamento' required value={departamento} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="sueldo" className="form-label">Sueldo</label>
                    <input type="number"min="0" step="any" className="form-control" id="sueldo" name='sueldo' required value={sueldo} onChange={(e) => onInputChange(e)}/>
                </div>
                <div className='text-center'>
                    <button type="submit" className="btn btn-primary btn-sm me-3">Agregar</button>
                    <Link to='/' className="btn btn-danger btn-sm me-3">Regresar</Link>
                </div>
            </form>
        </div>
    )
}
