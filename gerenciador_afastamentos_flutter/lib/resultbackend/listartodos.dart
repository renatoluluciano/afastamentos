import 'package:flutter/material.dart';
import 'package:gerenciador_afastamentos/controller/AgendamentoController.dart';
import 'package:gerenciador_afastamentos/model/Agendamento.dart';
import 'package:intl/intl.dart';

class Listartodos extends StatefulWidget {
  const Listartodos({super.key});

  @override
  State<Listartodos> createState() => _ListartodosState();
}

class _ListartodosState extends State<Listartodos> {
  var agendamentosList = <Agendamento>[];
  var agendamentosController = AgendamentoController();
  final dataPesquisa = DateTime.parse('2024-12-19');

  Future<void> _listarTodos() async {
    setState(() {});
    print('Entrou no setState');
    agendamentosList = await agendamentosController
        .agendamentosPorData(DateFormat('yyyy-MM-dd').format(dataPesquisa));
    //agendamentosList = await agendamentosController.todosAgendamentos();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Todos Agendamentos'),
      ),
      body: Column(
        children: [
          ElevatedButton(
            onPressed: () {
              _listarTodos();
            },
            child: Text('Clique aqui'),
          ),
        ],
      ),
    );
  }
}
