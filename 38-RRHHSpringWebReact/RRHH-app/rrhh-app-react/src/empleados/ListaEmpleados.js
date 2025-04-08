import React, { useEffect, useState } from "react";
import axios from 'axios';
import { NumericFormat } from 'react-number-format';

export default function ListaEmpleados() {

    const urlBase = "http://localhost:8080/rh-app/empleados";

    const [empleados, setEmpleados] = useState([]);

    useEffect(() => {
        cargarEmpleados();
    }, []);

    const cargarEmpleados = async () => {
        const resultado = await axios.get(urlBase);
        console.log('Resultado cargar empleado...')
        console.log(resultado.data);
        setEmpleados(resultado.data.empleados);
    }

    return (
        <div className="container">
            <div className="container mt-5 mb-5">
                <h1 className="text-center">Sistema de Recursos Humanos</h1>
            </div>
            <div>
                <table className='table table-dark table-hover table-striped align-middle'>
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Departamento</th>
                            <th scope="col">Sueldo</th>
                            <th scope="col">Fecha de captura</th>
                            <th scope="col">Última actualización</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            empleados.map((empleado) => (
                                <tr key={empleado.idEmpleado}>
                                    <th scope="row">{empleado.idEmpleado}</th>
                                    <td>{empleado.nombre}</td>
                                    <td>{empleado.departamento}</td>
                                    <td><NumericFormat value={empleado.sueldo}
                                        displayType={'text'}
                                        thousandSeparator=',' prefix={'$'}
                                        decimalScale={2} fixedDecimalScale/>
                                    </td>
                                    <td>{empleado.fechaCreacion}</td>
                                    <td>{empleado.fechaActualizacion} </td>
                                    <td></td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}
