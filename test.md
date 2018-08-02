
> #### 简介  
ELK为Elasticsearch、Logstash、Kibana简称,Filebeat为日志传输工具
1. Elasticsearch  
The Heart of the Elastic Stack,Elasticsearch是一个基于分布式RESTful风格的搜索和分析引擎，能够解决越来越多的用例,作为Elastic Stack的核心，它集中存储数据，以便预期发现意外情况
2. Logstash  
Logstash是一个开源的服务器端数据处理管道，它可以同时从多个源中提取数据，对其进行转换，然后将其发送到您最喜欢的"存储"
3. Kibana  
Your Window into 
the Elastic Stack,Kibana用来可视化Elasticsearch数据
4. Filebeat  
轻量级的日志、文件传输工具,filebeat会使用一个反压力敏感(backpressure-sensitive)的协议来解释高负荷的数据量,当数据处理繁忙时，Filebeat放慢它的读取速度.一旦压力解除,将恢复到原来的速度,继续传输数据  
简单的来说,Filebeat用来检测数据,把数据发送给Logstash,Logstash是具备实时传输数据的管道,将数据从管道的输入端传输到输出端,而且可以根据需要过滤、处理数据,Elasticsearch 是一个分布式搜索引擎,负责数据的存储、检索、分析,Kibana提供了可视化的界面,用于数据的可视化操作.

> #### 安装
从[https://www.elastic.co/products](https://www.elastic.co/products)官网上下载最新的安装包,
 1. 配置Elasticsearch  
 修改文件/elasticsearch-6.3.2/config/elasticsearch.yml:
    ```
    cluster.name: lios-boot-rest
    node.name: lios-boot
    path.data: /Users/wenchao.wang/dev/elk/logs
    path.logs: /Users/wenchao.wang/dev/elk/logs
    network.host: 127.0.0.1
    http.port: 9200
    ```
    启动服务:
    ```
    ./elasticsearch-6.3.2/bin/elasticsearch
    ```
 2. 配置Logstash  
 在/logstash-6.3.2/config目录下新建配置文件filebeat-to-es.conf:
     ```
     input {
    beats{
        type => "lios-boot-rest"
        host => "127.0.0.1"
        port => 5044
      }
    }
    output {
     elasticsearch{
     hosts => ["127.0.0.1:9200"]
     index => "lios-boot-rest-%{+YYYY.MM.dd}"
     }
    }
     ```
     启动服务:
    ```
    ./logstash-6.3.2/bin/logstash -f ./filebeat-to-es.conf 
    ```
3. 配置kibana  
    ```
    server.port: 5601
    server.host: "127.0.0.1"
    elasticsearch.url: "http://127.0.0.1:9200"
    kibana.index: ".kibana"
    ```
    启动服务:
    ```
    ./kibana-6.3.2-darwin-x86_64/bin kibana
    ```
4. 配置filebeat  
    ```
    filebeat.inputs:
    - type: log
      # Change to true to enable this input configuration.
      enabled: true
      # Paths that should be crawled and fetched. Glob based paths.
      paths:
      - /data/lios/logs/apps/lios-boot-rest/*.log
      tags: ["lios-boor-rest-log"]
      document_type: lios-boot-rest
      spool_size: 1024
      idle_timeout: "3s"
    filebeat.config.modules:
      path: ${path.config}/modules.d/*.yml
      reload.enabled: false
      # Period on which files under path should be checked for changes
      #reload.period: 10s
    setup.template.settings:
      index.number_of_shards: 3
    #----------------------------- Logstash output --------------------------------
    output.logstash:
      # The Logstash hosts
      hosts: ["127.0.0.1:5044"]
    ```
    启动filebeat服务
    
    ```
    mac上启动方式
    sudo chown root filebeat.yml
    sudo ./filebeat -e -c filebeat.yml -d "publish"
    ```
    发现filebeat已经向logstash发送数据了:
    ![https://note.youdao.com/yws/api/personal/file/WEB9d0e71c88ccb436a312e6747ac1c2e46?method=download&shareKey=47897f4682f9c75b134a928ad976766f](https://note.youdao.com/yws/api/personal/file/WEB9d0e71c88ccb436a312e6747ac1c2e46?method=download&shareKey=47897f4682f9c75b134a928ad976766f)

> #### 可视化

网址中输入``http://localhost:5601/``
![https://note.youdao.com/yws/api/personal/file/WEB67fc37afa7f12be50de95ae2d447afcb?method=download&shareKey=c0db3c5afcfaf14869ee68a7eb2f7b17](https://note.youdao.com/yws/api/personal/file/WEB67fc37afa7f12be50de95ae2d447afcb?method=download&shareKey=c0db3c5afcfaf14869ee68a7eb2f7b17)
创建索引:
![https://note.youdao.com/yws/api/personal/file/WEB4e269f40a4710edd267c3bddb0874a14?method=download&shareKey=7c241b06a656228479904e8e7cabea63](https://note.youdao.com/yws/api/personal/file/WEB4e269f40a4710edd267c3bddb0874a14?method=download&shareKey=7c241b06a656228479904e8e7cabea63)
创建索引成功后,发现已经可以看到数据了:
![https://note.youdao.com/yws/api/personal/file/WEBf032714873aecd77a05398651e621b24?method=download&shareKey=b508852230494de3f0943d32ed10b4e8](https://note.youdao.com/yws/api/personal/file/WEBf032714873aecd77a05398651e621b24?method=download&shareKey=b508852230494de3f0943d32ed10b4e8)
