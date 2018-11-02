	<template>
		<transition name="fade" mode="out-in">			
			<router-view></router-view>
		</transition>
	</template>

	<script>
	import { getCodeList } from './api/base/system.js'
	export default {
		data(){
			return{
			}
		},
		mounted(){
			getCodeList({})
				.then(res => {
					console.log(res);
				})
				.catch(err => {
					console.log(err);
				})
		}
	}
	</script>


	<style>		
		html, body, div, span, applet, object, iframe,
		h1, h2, h3, h4, h5, h6, p, blockquote, pre,
		a, abbr, acronym, address, big, cite, code,
		del, dfn, em, font, img, ins, kbd, q, s, samp,
		small, strike, strong, sub, sup, tt, var,
		b, u, i, center,
		dl, dt, dd, ol, ul, li,
		fieldset, form, label, legend,
		table, caption, tbody, tfoot, thead, tr, th, td {
			margin: 0;
			padding: 0;
			border: 0;
			outline: 0;
			font-size: 100%;
			vertical-align: baseline;
			background: transparent;
		}
		body {
			line-height: 1;
			font-family: "Microsoft Yahei";
		}
		ol, ul {
			list-style: none;
		}
		blockquote, q {
			quotes: none;
		}
		blockquote:before, blockquote:after,
		q:before, q:after {
			content: ”;
			content: none;
		}
		/* remember to define focus styles! */
		:focus {
			outline: 0;
		}
		/* remember to highlight inserts somehow! */
		ins {
			text-decoration: none;
		}
		del {
			text-decoration: line-through;
		}
		/* tables still need ‘cellspacing=”0″‘ in the markup */
		table {
			border-collapse: collapse;
			border-spacing: 0;
		}
		@media (max-width:1440px){
			htm,body{
				font-size:12px;
			}
			
		}		
		@media (min-width:1440px) and (max-width:1920px){
			htm,body{
				font-size:16px;
			}
			
		}
		@media (min-width:1921px){
			htm,body{
				font-size:20px;
			}
			
		}
	</style>
