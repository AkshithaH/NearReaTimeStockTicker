import { TestBed } from '@angular/core/testing';
import { CompanysService } from './companys.service';
describe('CompanyInfoService', function () {
    beforeEach(function () { return TestBed.configureTestingModule({}); });
    it('should be created', function () {
        var service = TestBed.get(CompanysService);
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=companys.service.spec.js.map