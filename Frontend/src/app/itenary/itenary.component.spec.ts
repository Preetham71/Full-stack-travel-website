import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItenaryComponent } from './itenary.component';

describe('ItenaryComponent', () => {
  let component: ItenaryComponent;
  let fixture: ComponentFixture<ItenaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ItenaryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItenaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
