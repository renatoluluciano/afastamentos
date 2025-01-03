import 'package:flutter/material.dart';
import 'package:gerenciador_afastamentos/controller/AgendamentoController.dart';
import 'package:gerenciador_afastamentos/model/Agendamento.dart';
import 'package:intl/intl.dart';

class ListarTodosPage extends StatefulWidget {
  const ListarTodosPage({super.key});

  @override
  State<ListarTodosPage> createState() => _ListartodosState();
}

class _ListartodosState extends State<ListarTodosPage> {
  var agendamentosList = <Agendamento>[];
  var agendamentosController = AgendamentoController();
  final dataPesquisa = DateTime.parse('2024-12-19');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Todos Agendamentos'),
      ),
      body: Column(),
    );
  }
}
