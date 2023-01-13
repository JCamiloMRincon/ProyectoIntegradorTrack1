const REGEX_EMAIL = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

export const validateEmail = (value, setError) => {
  let error = "";
  if (!REGEX_EMAIL.test(value)) {
    error = "Correo invalido";
  }
  setError((previous) => ({ ...previous, email: error }));
  return error;
};

export const validatePassword = (password, setError) => {
  let error = "";
  if (!password || password.length < 6) {
    error = "El minimo de caracteres es 6";
  }
  setError((previous) => ({ ...previous, password: error }));
  return error;
};
export const validateRePassword = (password, rePassword, setError) => {
  let error = "";
  if (!rePassword || rePassword.length < 6) {
    error = "El minimo de caracteres es 6";
  }
  if (password !== rePassword) {
    error = "La contraseña no coincide";
  }
  setError((previous) => ({ ...previous, rePassword: error }));
  return error;
};
