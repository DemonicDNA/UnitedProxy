# UnitedProxy
Configureable Application to listen to incoming messages and split them to number of hosts using various protocols.
Note: Right now only TCP is implemented.

# Example
We use config.yml to configure this app.
Ex:
```yml
# Incoming data will sent using TCP to this application on port 1591
incoming:
    protocol: tcp
    type: server
    port: 1591

# Outgoing data using TCP Protocol will be sent to the hosts using TCP Client
outgoing:
    protocol: tcp
    type: client
    hosts:
       - localhost:1991
       - localhost:1992
```
