# RabbitMQ

- Produtor: Envia as mensagens para a fila
- Consumiudor: Recebe as mensagens da fila
- Queue: Fila de mensagens
- Exchange: Recebe as mensagens dos produtores e "empurra" na fila para os receptores

# Configurações para o publicador

- durable: Define que a mensagem será durável, salva em disco, isso garante que quando o rabbitmq será reiniciado não perca as mensagens da fila.

# Configurações para o consumidor

- ACK: Envio de conformação do consumidor para dizer que a mensagem foi processada. Se definida esta propriedade o RBMQ aguarda a confirmação do processamento da mensagem por um tempo determinado (padrão 30 min). Se a mensagem não for processada antes do tempo limite ela vai para outro consumidor.