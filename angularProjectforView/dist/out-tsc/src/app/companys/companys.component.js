import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CompanysService } from "./companys.service";
var CompanysComponent = /** @class */ (function () {
    function CompanysComponent(router, CompanysService) {
        this.router = router;
        this.CompanysService = CompanysService;
    }
    CompanysComponent.prototype.ngOnInit = function () {
        //this.refresh();
        this.reloadData();
    };
    CompanysComponent.prototype.refresh = function () {
        window.location.reload();
    };
    CompanysComponent.prototype.reloadData = function () {
        var _this = this;
        this.CompanysService.findAll()
            .subscribe(function (data) {
            _this.companys = data;
        });
    };
    CompanysComponent.prototype.deleteCompany = function (companyId) {
        var _this = this;
        this.CompanysService.deleteCompany(companyId).subscribe(function (data) {
            console.log(data);
            _this.refresh();
        });
    };
    CompanysComponent = tslib_1.__decorate([
        Component({
            selector: 'app-company-info',
            templateUrl: './companys.component.html',
            styleUrls: ['./companys.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [Router, CompanysService])
    ], CompanysComponent);
    return CompanysComponent;
}());
export { CompanysComponent };
//# sourceMappingURL=companys.component.js.map