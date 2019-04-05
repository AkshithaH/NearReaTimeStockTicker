import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
var httpOptions = {
    headers: new HttpHeaders({ 'content-type': 'application-json' })
};
var CompanysService = /** @class */ (function () {
    function CompanysService(http) {
        this.http = http;
        this.Companys = [];
        this.companyUrl = 'http://localhost:8088/api/';
    }
    CompanysService.prototype.findAll = function () {
        return this.http.get(this.companyUrl);
    };
    CompanysService.prototype.deleteCompany = function (companyId) {
        return this.http.delete(this.companyUrl + companyId);
    };
    CompanysService.prototype.addCompany = function (Companys) {
        return this.http.post(this.companyUrl, Companys);
    };
    CompanysService.prototype.updateCompany = function (companys) {
        return this.http.put(this.companyUrl, companys);
    };
    CompanysService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], CompanysService);
    return CompanysService;
}());
export { CompanysService };
//# sourceMappingURL=companys.service.js.map