use ConsultorioMedico;

desc Anamnese;
desc Prontuario;
desc Usuario;
desc Paciente;
desc Medico;

select * from Usuario;
select * from Paciente;
select * from Medico;
select * from Prontuario;
select * from Anamnese;

insert into Usuario (login, senha, is_medico, nome, cpf) values
	("hemmerson", "1234", 1, "Hemmerson Rosa", "022.222.222-21");
insert into Medico (especializacao, Usuario_idUsuario) values ("Cirurgião", 1);

select u.login, u.senha, u.nome, u.cpf, m.especializacao from Usuario as u, Medico as m where idUsuario = Usuario_idUsuario;

select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario where login = "hemmerson" and senha = "1234";
select * from Usuario inner join Medico on idUsuario = Usuario_idUsuario;

select * from Usuario inner join Paciente on idUsuario = Usuario_idUsuario where idUsuario = 2;

SELECT * FROM Paciente WHERE dataNascimento BETWEEN '2016-05-11T00:00:00.000' and '2023-06-30T00:00:00.000';