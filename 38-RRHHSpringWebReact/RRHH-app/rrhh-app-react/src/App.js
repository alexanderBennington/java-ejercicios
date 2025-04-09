//import logo from './logo.svg';
//import './App.css';

import AgregarEmpleado from "./empleados/AgregarEmpleado";
import EditarEmpleado from "./empleados/EditarEmpleado";
import ListaEmpleados from "./empleados/ListaEmpleados";
import Navegacion from "./plantilla/Navegacion";
import {BrowserRouter, Route, Routes} from "react-router-dom";


function App() {
  return (
    <div>
      <BrowserRouter>
        <Navegacion/>
        <Routes>
          <Route exact path="/" element={<ListaEmpleados/>}/>
          <Route exact path="/agregar" element={<AgregarEmpleado/>}/>
          <Route exact path="/editar/:id" element={<EditarEmpleado/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
