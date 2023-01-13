import Searcher from '../Components/Searcher/Searcher.js';

import {render, screen} from '@testing-library/react';

test('prueba título', ()=>{

    render(<Searcher />);
    const titulo= screen.getByText(/Busca ofertas en departamentos, casas y mucho más/);
    expect(titulo).toBeInTheDocument();
})
