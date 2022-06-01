package com.dbchispano.hispacoins.controller;

import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.domain.ShopItem;
import com.dbchispano.hispacoins.domain.operation.CreditOperation;
import com.dbchispano.hispacoins.domain.operation.PurchaseOperation;
import com.dbchispano.hispacoins.domain.operation.TransferOperation;
import com.dbchispano.hispacoins.service.AccountService;
import com.dbchispano.hispacoins.service.OperationService;
import com.dbchispano.hispacoins.service.ShopItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private final AccountService ACCOUNT_SERVICE;
    private final OperationService<TransferOperation> TRANSFER_SERVICE;
    private final OperationService<CreditOperation> CREDIT_SERVICE;
    private final OperationService<PurchaseOperation> PURCHASE_SERVICE;
    private final ShopItemService SHOP_SERVICE;

    public OperationController(AccountService accountService,
                               OperationService<TransferOperation> transferService,
                               OperationService<CreditOperation> creditService,
                               OperationService<PurchaseOperation> purchaseService,
                               ShopItemService shopService) {
        ACCOUNT_SERVICE = accountService;
        TRANSFER_SERVICE = transferService;
        CREDIT_SERVICE = creditService;
        PURCHASE_SERVICE = purchaseService;
        SHOP_SERVICE = shopService;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not found")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    private void notFound() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid value")
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private void mismatch() {
    }

    @GetMapping("/transfer")
    public TransferOperation transfer(@RequestParam Account from,
                                      @RequestParam Account to,
                                      @RequestParam long amount) {
        //Account fromAccount = ACCOUNT_SERVICE.get(from).orElseThrow(NullPointerException::new);
        //Account toAccount = ACCOUNT_SERVICE.get(to).orElseThrow(NullPointerException::new);

        TransferOperation operation = TRANSFER_SERVICE.createOperation(new TransferOperation(amount, from, to));
        return TRANSFER_SERVICE.processor(operation).process();
    }

    @GetMapping("/credit")
    public CreditOperation credit(@RequestParam Account to, @RequestParam long amount) {
        //Account toAccount = ACCOUNT_SERVICE.get(to).orElseThrow(NullPointerException::new);

        CreditOperation operation = CREDIT_SERVICE.createOperation(new CreditOperation(amount, to));
        return CREDIT_SERVICE.processor(operation).process();
    }

    @GetMapping("/purchase")
    public PurchaseOperation purchase(@RequestParam Account buyer, @RequestParam ShopItem item) {
        //Account buyerAccount = ACCOUNT_SERVICE.get(to).orElseThrow(NullPointerException::new);
        //ShopItem purchase = SHOP_SERVICE.getById(item).orElseThrow(NullPointerException::new);

        PurchaseOperation operation = PURCHASE_SERVICE.createOperation(new PurchaseOperation(buyer, item));
        return PURCHASE_SERVICE.processor(operation).process();
    }

}
