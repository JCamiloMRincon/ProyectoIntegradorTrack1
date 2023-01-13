import CategoriesBlock from '../Components/Body/CategoriesBlock/CategoriesBlock.js';

import {render, screen} from '@testing-library/react';

test('prueba título', ()=>{

    render(<CategoriesBlock />);
    const titulo= screen.getByText(/Categorías/);
    expect(titulo).toBeInTheDocument();
})

test('prueba subtitulo', ()=>{

    render(<CategoriesBlock />);
    const subtitulo= screen.getByText(/Selecciona el tipo de alojamiento que se adapte a tu necesidad/);
    expect(subtitulo).toBeInTheDocument();
})
