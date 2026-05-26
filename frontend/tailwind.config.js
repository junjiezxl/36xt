/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: '#3b82f6', // Tailwind blue-500
        dark: '#1e293b',    // Tailwind slate-800
      }
    },
  },
  plugins: [],
}
