import 'package:dart_frog/dart_frog.dart';

Response onRequest(RequestContext context) {
  print('response: hello world');
  return Response(body: 'Hello World!');
}
