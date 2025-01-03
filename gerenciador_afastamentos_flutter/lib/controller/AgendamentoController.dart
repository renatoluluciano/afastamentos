import 'dart:convert';

import 'package:gerenciador_afastamentos/model/Agendamento.dart';
import 'package:http/http.dart' as http;

class AgendamentoController {
  Future<List<Agendamento>> todosAgendamentos() async {
    final agendamentoResponse =
        await http.get(Uri.parse('http://localhost:8080/agendamentos'));

    if (agendamentoResponse.statusCode != 200) {
      throw Exception('Erro na requisição');
    }

    final agendamentoData = jsonDecode(agendamentoResponse.body);

    final agendamentoList =
        agendamentoData.map((e) => Agendamento.fromMap(e)).toList();

    return agendamentoList;
  }

  Future<List<Agendamento>> agendamentosPorData(String data) async {
    final agendamentoResponse =
        await http.get(Uri.parse('http://localhost:8080/agendamentos/$data'));

    print('data repassada na requisicao: ${data}');

    if (agendamentoResponse.statusCode != 200) {
      throw Exception('Erro na requisição');
    }

    print(agendamentoResponse.statusCode);

    final agendamentoData = jsonDecode(agendamentoResponse.body) as List;

    final agendamentoList =
        agendamentoData.map((e) => Agendamento.fromMap(e)).toList();

    print(agendamentoList);

    return agendamentoList;
  }
}
