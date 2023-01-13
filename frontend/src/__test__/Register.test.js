import Register from '../Components/Auth/Register/Register.js';

import {render, screen} from '@testing-library/react';
import {BrowserRouter as Router} from 'react-router-dom';

test('prueba Register correo', ()=>{

    render(<Router> <Register /> </Router>);
    const titulo= screen.getByText(/Correo electrónico/);
    expect(titulo).toBeInTheDocument();
})

test('prueba Register Contraseña', ()=>{

    render(<Router> <Register /> </Router>);
    const titulo= screen.getByText(/Contraseña/);
    expect(titulo).toBeInTheDocument();
})

test('prueba Register Re contraseña', ()=>{

    render(<Router> <Register /> </Router>);
    const titulo= screen.getByText(/Confirmar contraseña/);
    expect(titulo).toBeInTheDocument();
})

test('prueba Register Nombre', ()=>{

    render(<Router> <Register /> </Router>);
    const titulo= screen.getByText(/Nombre/);
    expect(titulo).toBeInTheDocument();
})

test('prueba Register Apellido', ()=>{

    render(<Router> <Register /> </Router>);
    const titulo= screen.getByText(/Apellido/);
    expect(titulo).toBeInTheDocument();
})