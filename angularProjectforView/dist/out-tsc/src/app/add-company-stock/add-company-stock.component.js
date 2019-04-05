import * as tslib_2 from "tslib";
import { Component } from '@angular/core';
import { Companys } from '../models/companys-model';
import { Router } from '@angular/router';
import { CompanysService } from './../companys/companys.service';
var AddCompanyStockComponent = /** @class */ (function () {
    function AddCompanyStockComponent(router, companysService) {
        this.router = router;
        this.companysService = companysService;
        this.companys = new Companys("", "", null, null, null, null, "");
    }
    AddCompanyStockComponent.prototype.addCompany = function () {
        console.log(this.companys);
        this.companysService.addCompany(this.companys).subscribe(function (data) {
            alert("company info is successfully added");
        });
    };
    AddCompanyStockComponent = tslib_2.__decorate([
        Component({
            selector: 'app-add',
            templateUrl: './add-company-stock.component.html',
            styleUrls: ['./add-company-stock.component.css']
        }),
        tslib_2.__metadata("design:paramtypes", [Router, CompanysService])
    ], AddCompanyStockComponent);
    return AddCompanyStockComponent;
}());
export { AddCompanyStockComponent };
//# sourceMappingURL=add-company-stock.component.js.map