<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>

.z-fixedtable {
	box-sizing: border-box;
	overflow: auto;
}

.z-fixedtable-table {
	border-spacing: 0;
}

.z-fixedtable-fixed-left,
.z-fixedtable-fixed-right,
.z-fixedtable-fixed-top,
.z-fixedtable-fixed-bottom {
	z-index: 1;
    position: sticky;
    background-color: skyblue;
}

.z-fixedtable-fixed-top.z-fixedtable-fixed-left,
.z-fixedtable-fixed-top.z-fixedtable-fixed-right,
.z-fixedtable-fixed-bottom.z-fixedtable-fixed-left,
.z-fixedtable-fixed-bottom.z-fixedtable-fixed-right {
	z-index: 2;
    background-color: gray;
}

.z-tablerow {
	height: 50px;
}

.z-tablerow:first-child > .z-tablecell {
	border-top: none;
}

.z-tablecell {
	text-align: center;
	border-left: 1px solid;
	border-top: 1px solid;
}

.z-tablecell:first-child {
	border-left: none;
}