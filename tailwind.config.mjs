/** @type {import('tailwindcss').Config} */
export default {
	content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
	theme: {
		extend: {
			colors: {
				parchment: '#f7f4ed',
				charcoal: '#1c1c1c',
				subtle: '#eceae4',
				brand: '#0ea5e9', // Using a generic brand color, can adjust
			},
			boxShadow: {
				insetSoft: 'inset 0 2px 4px 0 rgba(0, 0, 0, 0.02)',
			},
			fontFamily: {
				sans: ['Inter', 'system-ui', 'sans-serif'],
			}
		},
	},
	plugins: [
		require('@tailwindcss/typography'),
		require('tailwindcss-animate'),
	],
}
