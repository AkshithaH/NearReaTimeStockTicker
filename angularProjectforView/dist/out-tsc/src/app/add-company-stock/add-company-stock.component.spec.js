import { async, TestBed } from '@angular/core/testing';
import { AddCompanyStockComponent } from './add-company-stock.component';
describe('AddCompanyStockComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [AddCompanyStockComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(AddCompanyStockComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=add-company-stock.component.spec.js.map