/*package com.web.api.elastic.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.web.api")
@ComponentScan(basePackages = { "com.web.api" })
public class ElasticSearchConfig {

	@Bean
	public NodeBuilder nodeBuilder() {
		return new NodeBuilder();
	}

	@Bean
	public Client client() {

		TransportClient client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", "elasticsearch")
				.put("client.transport.ignore_cluster_name", false).build());
		TransportAddress adress = null;

		try {
			adress = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200);
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		client.addTransportAddress(adress);
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
}*/