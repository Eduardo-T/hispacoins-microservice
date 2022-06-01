package com.dbchispano.hispacoins.configuration;

import com.dbchispano.hispacoins.domain.operation.CreditOperation;
import com.dbchispano.hispacoins.domain.operation.PurchaseOperation;
import com.dbchispano.hispacoins.domain.operation.TransferOperation;
import com.dbchispano.hispacoins.processor.BaseOperationProcessor;
import com.dbchispano.hispacoins.repository.OperationRepository;
import com.dbchispano.hispacoins.service.BaseOperationService;
import com.dbchispano.hispacoins.service.OperationService;
import com.dbchispano.hispacoins.worker.OperationWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationServiceConfig {

    @Bean
    public OperationService<TransferOperation> transferService(OperationRepository<TransferOperation> repository, OperationWorker<TransferOperation> worker) {
        return new BaseOperationService<TransferOperation>(repository, transferOperation -> new BaseOperationProcessor<TransferOperation>(transferOperation, worker));
    }

    @Bean
    public OperationService<PurchaseOperation> purchaseService(OperationRepository<PurchaseOperation> repository, OperationWorker<PurchaseOperation> worker) {
        return new BaseOperationService<PurchaseOperation>(repository, purchaseOperation -> new BaseOperationProcessor<PurchaseOperation>(purchaseOperation, worker));
    }

    @Bean
    public OperationService<CreditOperation> creditService(OperationRepository<CreditOperation> repository, OperationWorker<CreditOperation> worker) {
        return new BaseOperationService<CreditOperation>(repository, creditOperation -> new BaseOperationProcessor<CreditOperation>(creditOperation, worker));
    }

}
