import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CompanysComponent } from './companys/companys.component';
import { AddCompanyStockComponent } from './add-company-stock/add-company-stock.component';
var routes = [
    { path: 'company-info', component: CompanysComponent },
    { path: 'add', component: AddCompanyStockComponent },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());
export { AppRoutingModule };
//# sourceMappingURL=app-routing.module.js.map