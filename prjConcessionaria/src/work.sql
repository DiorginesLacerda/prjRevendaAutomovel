use dconcessionaria;

select * from marca;
select * from modelo;
select * from carro; 
select * from carro_acessorio;
select * from proprietario;
select * from venda;
select * from parcela;

insert into marca (id_marca,nome_marca) values (2,"Volkswagen");



delete from modelo where id_modelo = 6;
delete from marca where id_marca = 2;
delete from carro where id_carro=2;
delete from venda where nro_venda<10;
delete from parcela where id_parcela<10;