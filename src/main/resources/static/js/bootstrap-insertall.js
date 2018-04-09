BootstrapTable.prototype.insertRowForm = function() {
 var $table = this.$el;
 var $options = this.options;
 var $data = this.getData();
 var $columns = $options.columns[0];
 var $forms = {};
 $.each($columns, function() {
 var $fieldIndex = this.fieldIndex;
 var $field = this.field;
 var $visible = this.visible;
 var $checkbox = this.checkbox;
 var $defaultValue = this.defaultValue;
 if (this.edit) {
 var clazz = "", name = "";
 var $value;
 // 判断表单类型
 var $formData = this.formData;
 var $isSelect = $formData.select;
 var $isTextarea = $formData.textarea;
 var $isInput = $formData.input;
 var $inputType = $formData.inputType;
 // 表单属性
 if (undefined != $formData.clazz) {
 clazz = "class='" + $formData.clazz + "'";
 }
 name = "name='" + $field + "'";
 if ($visible) {
 var html = [];
 // select下拉框
 if ($isSelect) {
 html.push("<select");
 html.push(name);
 html.push(clazz);
 html.push(">");
 $.each($formData.options, function() {
 var selected = "";
 if (this.selected) {
 selected = ' selected="true"';
 }
 var option = '<option value="' + this.value + '" ' + selected + '>' + this.text + '</option>'
 html.push(option);
 });
 html.push("</select>");
 } else if ($isTextarea) { // textarea文本域
 html.push("<textarea");
 html.push(name);
 html.push(clazz);
 html.push("></textarea>");
 } else if ($isInput) {
 if (undefined == $inputType || $inputType == "text") {
 html.push("<input");
 html.push(name);
 html.push(clazz);
 html.push("type='text'>");
 } else if ($inputType == "checkbox") {
 $.each($formData.values, function() {
 html.push("<input");
 html.push(name);
 html.push(clazz);
 html.push("type='checkbox' value='" + this.value + "'>" + this.text);
 });
 }
 } else if ($checkbox) {
 html.push("<input");
 html.push(name);
 html.push(clazz);
 html.push("type='checkbox' value='" + $defaultValue + "'>");
 }
 $forms[$fieldIndex] = html.join(" ");
 }
 } else {
 $forms[$fieldIndex] = "";
 }
 });
 $forms[$columns.length - 1] = "<a href='javascript:void(0);' title='删除' class='removeRowForm'><i class='icon-trash-empty-1'></i></a>";
 var $rowIndex = $table.find("tr").length - 1;
 var tr = '<tr class="selected" data-index="' + $rowIndex + '">';
 $.each($columns, function() {
 var $fieldIndex = this.fieldIndex;
 $.each($forms, function(key, value) {
 if (key == $fieldIndex) {
 var td = '<td style="text-align: center; vertical-align: middle; ">' + value + '</td>';
 tr += td;
 }
 });
 });
 tr += "</tr>";
 $table.find(" tbody").eq(0).append(tr);
 $(".removeRowForm").click(function() {
 $(this).parent().parent().remove();
 });
};