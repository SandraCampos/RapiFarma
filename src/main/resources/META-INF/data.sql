INSERT INTO proveedores (nombre, direccion, email, telefono, contacto, ruc) VALUES ('Laboratorio 1 S.A.C', 'mi dirección', 'laboratorio1@hotmail.com', '946898615', 'José Denegri', '12345678912')
INSERT INTO proveedores (nombre, direccion, email, telefono, contacto, ruc) VALUES ('Laboratorio 2 S.A.C', 'mi dirección', 'laboratorio2@hotmail.com', '946898614', 'Samir Samir', '12345678912')
INSERT INTO proveedores (nombre, direccion, email, telefono, contacto, ruc) VALUES ('Laboratorio 3 S.A.C', 'mi dirección', 'laboratorio3@hotmail.com', '946898613', 'Sandra Sandra', '12345678912')
INSERT INTO proveedores (nombre, direccion, email, telefono, contacto, ruc) VALUES ('Laboratorio 4 S.A.C', 'mi dirección', 'laboratorio4@hotmail.com', '946898612', 'Teresa Teresa', '12345678912')

INSERT INTO categorias (nombre) VALUES ('Categoria 1')
INSERT INTO categorias (nombre) VALUES ('Categoria 2')
INSERT INTO categorias (nombre) VALUES ('Categoria 3')
INSERT INTO categorias (nombre) VALUES ('Categoria 4')

INSERT INTO productos (codigo, categorias_codigo, proveedores_codigo, nombre, precio_venta, stock, und_med, ubicacion, stock_minimo) VALUES ('ABC123', 1, 1, 'PRODUCTO 1', 35, 10, 'und', 'AK-21', 50)
INSERT INTO productos (codigo, categorias_codigo, proveedores_codigo, nombre, precio_venta, stock, und_med, ubicacion, stock_minimo) VALUES ('DEF123', 2, 2, 'PRODUCTO 2', 25, 5, 'und', 'AK-21', 40)
INSERT INTO productos (codigo, categorias_codigo, proveedores_codigo, nombre, precio_venta, stock, und_med, ubicacion, stock_minimo) VALUES ('GHI123', 3, 3, 'PRODUCTO 3', 15, 5, 'und', 'AK-21', 20)
INSERT INTO productos (codigo, categorias_codigo, proveedores_codigo, nombre, precio_venta, stock, und_med, ubicacion, stock_minimo) VALUES ('JKL123', 4, 4, 'PRODUCTO 4', 55, 5, 'und', 'AK-21', 30)

INSERT INTO usuarios (usuario, clave, vigente) VALUES ('admin', 'admin', 'S')