package com.build.devtest;

import java.util.ArrayList;

import java.util.List;

public class ParentViewMapperImpl implements ParentViewMapper {
  
  /*
   * Returns a List of ParentView along with childRows to parentRows mapping
   * @parentRows: a List of objects of parentRow
   * @childRows: a List of objects of childRow
   * @return: a List containing mapping of parentView with childView
   * */
  
  @Override
  public List<ParentView> mapRowsToViews(List<ParentRow> parentRows, List<ChildRow> childRows) {
    List<ParentView> listParentView = new ArrayList<ParentView>();
    
    for(ParentRow varParentRow : parentRows) {
      ParentView objParentView = new ParentView(varParentRow.getFirstName(),
                                                varParentRow.getLastName(),
                                                varParentRow.getAge(),
                                                varParentRow.getParentId(),
                                                null);
    
      List<ChildView> listChildView = new ArrayList<ChildView>();
      
      for(ChildRow varChildRow : childRows) {
        if(varParentRow.getParentId().equalsIgnoreCase(varChildRow.getParentId())) {
          ChildView objChildView = new ChildView(varChildRow.getFirstName(),
                                                 varChildRow.getLastName(),
                                                 varChildRow.getAge(),
                                                 varChildRow.getParentId(),
                                                 objParentView);
          
          listChildView.add(objChildView);
        }
      }
      objParentView.setChildViews(listChildView);
      listParentView.add(objParentView);
    }
    return listParentView;
  }
}
