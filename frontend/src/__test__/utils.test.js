
const {validatePassword} = require('../Components/Auth/utils.js');
const {validateEmail} = require('../Components/Auth/utils.js');
const {validateRePassword} = require('../Components/Auth/utils.js');


test('Validar email', () => {    
   
    const email = validateEmail("marisabelalbarracin.com", (previous => ({})))
    expect(email).toBe('Correo invalido');
    
})

test('validatePassword', () => {    
   
    const password = validatePassword("1234")
    expect(password).toBe('El minimo de caracteres es 6');
    
})

test('validateRePassword', () => {    
   
    const repassword = validateRePassword("123456", "12345", (previous => ({})))
    expect(repassword).toBe('La contraseña no coincide');
    
})